FROM node:17-alpine

WORKDIR /index.js

EXPOSE 3000

COPY package.json .

RUN npm install

ENTRYPOINT ["node", "index.js"]