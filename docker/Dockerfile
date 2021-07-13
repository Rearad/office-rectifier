FROM centos
ADD ./lib/Apache_OpenOffice_4.1.10_Linux_x86-64_install-deb_zh-CN.tar.gz /tmp/
ADD ./lib/chinses.tar.gz /usr/share/fonts/
RUN cd /tmp && \
yum install -y zh-CN/RPMS/*.rpm && \
yum install -y java-1.8.0-openjdk.x86_64 && \
yum clean all && \
rm -rf zh-CN && \
cd /usr/share/fonts/ && \
chmod -R 755 /usr/share/fonts && \
mkfontscale && \
mkfontdir && \
fc-cache -fv
EXPOSE 8100
ENV JAVA_HOME /usr/lib/jvm/jre-1.8.0-openjdk-1.8.0.222.b10-0.el7_6.x86_64
CMD /opt/openoffice4/program/soffice -headless -nofirststartwizard  -accept="socket,host=0.0.0.0,port=8100;urp;"
VOLUME /tmp