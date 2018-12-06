#!/usr/bin/env bash
set -e

echo "================================="
echo "Démarrage du serveur H2"

java -cp $H2_HOME/h2-1.4.193.jar org.h2.tools.Server \
      -web -webAllowOthers -webPort 8082 -tcp -tcpAllowOthers &

exec "$@"
