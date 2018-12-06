# Use latest jboss/base-jdk:8 image as the base
FROM jboss/base-jdk:8

# Set the WILDFLY_VERSION env variable
ENV WILDFLY_VERSION 14.0.1.Final
ENV WILDFLY_SHA1 757d89d86d01a9a3144f34243878393102d57384
ENV JBOSS_HOME /opt/jboss/wildfly
ENV H2_HOME $JBOSS_HOME/modules/system/layers/base/com/h2database/h2/main/

USER JBOSS

USER root

# Add the WildFly distribution to /opt, and make wildfly the owner of the extracted tar content
# Make sure the distribution is available from a well-known place
RUN cd $HOME \
    && curl -O https://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz \
    && sha1sum wildfly-$WILDFLY_VERSION.tar.gz | grep $WILDFLY_SHA1 \
    && tar xf wildfly-$WILDFLY_VERSION.tar.gz \
    && mv $HOME/wildfly-$WILDFLY_VERSION $JBOSS_HOME \
    && rm wildfly-$WILDFLY_VERSION.tar.gz \
    && chown -R jboss:0 ${JBOSS_HOME} \
    && chmod -R g+rw ${JBOSS_HOME}

RUN $JBOSS_HOME/bin/add-user.sh jean-michel jar

ADD build/libs/EJB-TP.ear $JBOSS_HOME/standalone/deployments
ADD standalone-full.xml $JBOSS_HOME/standalone/configuration

ADD setup.sh $JBOSS_HOME
RUN chmod +x $JBOSS_HOME/setup.sh

# Ensure signals are forwarded to the JVM process correctly for graceful shutdown
ENV LAUNCH_JBOSS_IN_BACKGROUND true

USER jboss

# Expose the ports we're interested in
EXPOSE 8080
EXPOSE 8082

# Popotte pour démarrer H2 et démarrage de Wildfly
CMD $JBOSS_HOME/setup.sh \
    && $JBOSS_HOME/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 \
      -c standalone-full.xml
