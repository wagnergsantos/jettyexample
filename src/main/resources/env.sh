#!/bin/bash

if [[ -z ${JAVA_HOME} ]]; then
export JAVA_HOME="/opt/taobao/java";
fi

MemTotal=`cat /proc/meminfo | grep "MemTotal"| awk -F" " '{printf $2;}';`
if [[ -z ${MemTotal} ]]; then
    echo "FATAL: cat /proc/meminfo failed"
fi
# unit is M
mem=$[$MemTotal/1024]
mem=$[$mem - $mem%100]
xmx=$[$mem*9/10]
xmx=$[$xmx-$xmx%100]
xmn=$[$xmx*1/2]
xmn=$[$xmn-$xmn%100]

MEM_OPTS="-Xms${xmx}m -Xmx${xmx}m -Xmn${xmn}m"

JAVA_OPTS="-server $MEM_OPTS"
JAVA_OPTS="$JAVA_OPTS -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${BASE_LOG}/java.hprof"
JAVA_OPTS="$JAVA_OPTS -verbose:gc -Xloggc:${BASE_LOG}/gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps"
JAVA_OPTS="$JAVA_OPTS -Dsun.net.client.defaultConnectTimeout=10000"
JAVA_OPTS="$JAVA_OPTS -Dsun.net.client.defaultReadTimeout=30000"
JAVA_OPTS="$JAVA_OPTS -XX:-OmitStackTraceInFastThrow"
JAVA_OPTS="$JAVA_OPTS -Dlog.dir=${BASE_LOG}"

export JAVA_OPTS
