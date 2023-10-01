# Stage 1: Build the Angular application
FROM node:16 as build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

#Stage 2: Server the Angular application using the Nginx
FROM nginx:alpine
COPY  --from=build /app/dist/food-delivery-app /usr/share/nginx/html
EXPOSE 80
CMD [ "nginx", "-g", "daemon off;" ]
