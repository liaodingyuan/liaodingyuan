#启动 startup.sh 启动项目
#!/bin/sh
echo "授予当前用户权限"
chmod 777 /usr/local/SBA/model.jar
echo "执行....."
nohup java -jar /usr/local/SBA/model.jar &