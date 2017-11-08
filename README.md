MicroV Application
============
Dropwizard microservice that provides recommendations of micro-volunteering events based on user interests.
To build and run with docker:
1. Run `./gradlew distTar` _this tells gradle to make a .tar file containing the java application code and all dependencies_
2. Run `docker build -t myapp .` _this runs the Dockerfile, and builds an image tagged with `myapp`.  See all images with `docker images`_
3. Run `docker run -p 80:8080 myapp` _this runs the `myapp` image, routing port 80 on **Your Machine** to port 8080 in **the container**_


TODOs:
- improve interest tagging on event add using nlp lib
- return tagged event interest names in get recommendation
- add user_blacklist to filter out events disliked by user
- nightly batch to send emails containing interested volunteers to nonprofits
- other marked TODOs