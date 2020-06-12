FROM node:10.11.0-alpine
ENV MB_VERSION=1.16.0
RUN npm config set unsafe-perm true && npm install -g mountebank@${MB_VERSION} --production && mkdir -p /mountebank/servers
CMD [ -s /mountebank/servers/service.ejs ] && mb --configfile /mountebank/servers/service.ejs --loglevel debug --allowInjection
EXPOSE 2525 80