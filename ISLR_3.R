### Dataset library
library(MASS)
library(ISLR)

### Simple linear regression
names(Boston)
?Boston
### Boston is Housing Values in Suburbs of Boston

### Plotting medv against lstat. Data is from Boston dataset
plot(medv~lstat,Boston)

### Fitting linear model
fit1 = lm(medv~lstat,Boston)
fit1
summary(fit1)
abline(fit1,col="red")
names(fit1)

### Confident interval
confint(fit1)

### Predict
predict(fit1,data.frame(lstat=c(5,10,15)),interval="confidence")

### Multiple linear regssion
fit2=lm(medv~lstat+age,data=Boston)
summary(fit2)

### Use all other variables for fit
fit3 = lm(medv~.,data=Boston)
summary(fit3)
plot(fit3)
fit4=update(fit3,~.-age-indus)
summary(fit4)

### Nonlinearity and Interaction
fit5 = lm(medv~lstat*age,data=Boston)
summary(fit5)

fit6 = lm(medv~lstat+I(lstat^2), data = Boston)
summary(fit6)

attach(Boston)
par(mfrow=c(1,1))
plot(medv~lstat)
points(lstat,fitted(fit6),col="red",pch=20)
fit7=lm(medv~poly(lstat,4))
points(lstat,fitted(fit7),col="blue",pch=20)

### Plot characteristic
plot(1:20,1:20,pch=1:20,cex=2)

### Qualitative predictor
fix(Carseats)
names(Carseats)
summary(Carseats)
fit1=lm(Sales~.+Income:Advertising+Age:Price,Carseats)
summary(fit1)

### See how the dummy variables are code
contrasts(Carseats$ShelveLoc)

### Writing R functions
regplot = function(x,y){
  fit=lm(y~x)
  plot(x,y)
  abline(fit,col="red")
}

### Writing R functions with dot dot dot - allow extra argument

regplot = function(x,y,...){
  fit=lm(y~x)
  plot(x,y,...)
  abline(fit,col="red")
}


