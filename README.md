# Conjur Guide

## Table of Contents
- [Prequisites](#prerequisites)
- [Conjur Java API](#conjur-java-api)
- [Setup Environment Variables](#setup-environment-variables)
- [Setup Certificate](#setup-certificate)

### Prerequisites
this tutorial assumed that you have followed instructions of 
[OSS](https://docs.conjur.org/Latest/en/Content/OSS/Installation/Install_methods.htm) and 
all the prerequisites mentioned in the documentation. If you are using docker follow 
[this](https://docs.conjur.org/Latest/en/Content/OSS/Installation/DockerCompose.htm) instructions, step by step 
guide conjur using docker please follow [this](https://www.conjur.org/get-started/quick-start/oss-environment/).

### Conjur Java API
you need to install (if you are manually installed jar in your project and not using maven), follow 
[Conjur Java API](https://github.com/cyberark/conjur-api-java) installation instruction, everything explained in the 
README sections. If you are using maven you can add this dependency to your project.

```xml
<dependency>
  <groupId>net.conjur.api</groupId>
  <artifactId>conjur-api</artifactId>
  <version>2.1.0</version>
</dependency>
```
 
### Setup Environment Variables
Either you are using Linux or Windows please add these environment variables:
- `CONJUR_ACCOUNT`
- `CONJUR_AUTHN_LOGIN`
- `CONJUR_AUTHN_API_KEY`
- `CONJUR_APPLIANCE_URL`

`CONJUR_ACCOUNT` - account specified during Conjur setup

`CONJUR_APPLIANCE_URL` - Conjur HTTPS endpoint (OSS/DAP)

`CONJUR_AUTHN_LOGIN` - user/host identity

`CONJUR_AUTHN_API_KEY` - user/host API key

if you have followed step by step setup a conjur OSS, you can get your `CONJUR_ACCOUNT` after create admin account. 
for `CONJUR_APPLIANCE_URL`, i'm using https://127.0.0.1:8443, since i'm running on my local machine. the other 
two `CONJUR_AUTHN_LOGIN` and `CONJUR_AUTHN_API_KEY`, i used user:<your_user_defined_your_policy> and 
<user_key_generated_when_load_the_policy>. 

### Setup Certificate
please import certificate which comes from OSS setup environment in the folder conf/tls/nginx.crt. after 
certificate is imported you can run this project. 
