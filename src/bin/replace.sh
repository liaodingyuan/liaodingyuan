#备份 replace.sh 用于将上次构建的结果备份，然后将新的构建结果移动到合适的位置
#!/bin/bash
# 先判断文件是否存在，如果存在，则备份
file="/usr/local/SBA/model.jar"
if [ -f "$file" ]
then
   mv /usr/local/SBA/model.jar /usr/local/SBA/backup/model.jar.`date +%Y%m%d%H%M%S`
fi
mv /root/.jenkins/workspace/Test/target/model.jar /usr/local/SBA/model.jar