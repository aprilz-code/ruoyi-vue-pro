#!/usr/bin/env bash

echo '=====开始关闭运行的容器====='
echo '=========================='
echo '=====结束后台服务运行====='
echo '=========================='

docker-compose -f ./yudao-server.yml down

echo '=====开始更新镜像====='
docker pull registry.cn-shenzhen.aliyuncs.com/whiteblog/yudao-server


echo '=====删除docker标签为none的镜像====='
docker images | grep none | awk '{print $3}' | xargs docker rmi

echo '=====开始运行的一键部署脚本====='
echo '======================'
echo '=====开始运行后台====='
echo '======================'

echo '=====开始运行容器====='
docker-compose -f ./yudao-server.yml up -d

echo '执行完成 日志目录: ./log'
