#!/bin/sh

BASE=$(cd $(dirname $0)/..; pwd);
BASE_LIB=${BASE}/lib;
BASE_CONF=${BASE}/conf;
BASE_LOG=${BASE}/logs;
ENV_FILE=${BASE_CONF}/env.sh;
MAIN_CLASS="com.ifen.web.MyJetttyServerMain"

${JAVA_HOME}/bin/java ${JAVA_OPTS} -Dlog.dir=${BASE_LOG} -classpath "${BASE_CONF}:${BASE_CONF}/dao:${BASE_LIB}/*" ${MAIN_CLASS} > ${BASE_LOG}/main.out
