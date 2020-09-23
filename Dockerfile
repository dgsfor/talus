FROM openjdk
MAINTAINER dgsfor@gmail.com

EXPOSE 9000

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

RUN mkdir /www/

ADD target/talus-0.0.1.jar /www/

CMD ["java","-jar","-Dspring.profiles.active=prod","/www/talus-0.0.1.jar"]