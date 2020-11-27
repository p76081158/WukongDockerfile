    FROM alpine:3.12
    MAINTAINER Vcx p76081158@gs.ncku.edu.tw

    USER root

    COPY tmp /root/

    ENV PATH=$PATH:/root/gradle-2.4/bin
    ENV PYTHONUNBUFFERED=1
    ENV device udpdevice_intel_sound.py
    ENV gtwip 127.0.0.1
    ENV port 3000

    RUN apk add --no-cache openjdk7 && \
        apk add --no-cache libevent-dev libxml2-dev libxslt-dev zlib-dev && \
        apk add --no-cache gcc make musl-dev linux-headers && \
        apk add --no-cache --update bash && \
        apk add --no-cache python2-dev && \
        apk add --no-cache portaudio-dev && \
        python -m ensurepip && \
        rm -r /usr/lib/python*/ensurepip && \
        pip install setuptools==44.0.0 && \
        pip install configobj==5.0.6 && \
        pip install simplejson==3.17.0 && \
        pip install gevent==1.1.2 && \
        pip install tornado==4.4 && \
        pip install jinja2==2.11.2 && \
        pip install pyserial==3.4 && \
        pip install lxml==4.4.2 && \
        pip install netifaces==0.10.9 && \
        pip install python-cjson==1.2.2 && \
        pip install twisted==20.3.0 && \
        pip install pyaudio==0.2.11 && \
        cd /root/wukong-darjeeling/src/infuser/ && \
        gradle && \
        cd /root/wukong-darjeeling/wukong/gateway/udpwkpf && \
        echo "#!/bin/sh"  >> run_device.sh && \
        echo 'python "$device" "$gtwip" "$(hostname -i)":"$port"' >> run_device.sh && \
        rm -rf /root/gradle-2.4/ && \
        rm -r /root/.cache

    WORKDIR /root/wukong-darjeeling/wukong/gateway/udpwkpf

    CMD ["/bin/sh", "./run_device.sh"]
