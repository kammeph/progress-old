FROM node:alpine as build

RUN mkdir -p /app

WORKDIR /app

COPY package.json .

RUN npm install

COPY . .

RUN npm run build --prod

FROM nginx:alpine

COPY nginx/default.conf.template /etc/nginx/templates/

COPY nginx/substitute_env_variables.sh /docker-entrypoint.d/

COPY --from=build /app/dist/frontend /usr/share/nginx/html