# Mountebank
mountebank is the first open source tool to provide cross-platform, multi-protocol test doubles over the wire. Simply point your application under test to mountebank instead of the real dependency, and test like you would with traditional stubs and mocks.

mountebank is the most capable open source service virtualization tool in existence, and will cure what ails you, guaranteed.

## 01-configuration
Demo to show initial setup of mountebank by docker container.

### Generate docker image
```
cd src/test/resources/docker
docker build --tag mountebank:0.0.1 .
```

### Tag docker image
```
docker tag mountebank:0.0.1 nexus.<url-repositorio>/mountebank:latest
```

### Push docker image
```
docker push mountebank:0.0.1 nexus.<url-repositorio>/mountebank:latest
```

### Run docker container
```
cd src/test/resources/docker
docker-compose up
```
