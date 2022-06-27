FROM node:17-alpine

WORKDIR /client

EXPOSE 3000

COPY package.json .

RUN npm install


RUN npm install

ENTRYPOINT ["node", "index.js"]