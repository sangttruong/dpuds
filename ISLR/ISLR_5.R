library(ISLR)
library(boot)
?cv.glm
plot(mpg~horsepower, data = Auto)

# LOOCV: leave one out cross validation
?glm
glm.fit=glm(mpg~horsepower, data=Auto)
cv.glm(Auto, glm.fit)$delta #Pretty slow (doesn't use formula 5.2 on page 180)


# LOOCV: write a simple function to use formula 5.2
loocv = function(fit){
  h = lm.influence(fit)$h
  mean((residuals(fit)/(1-h))^2)
}

loocv(glm.fit)
print(glm.fit)

cv.error=rep(0,5)
degree = 1:5

for(d in degree){
  glm.fit = glm(mpg~poly(horsepower,d), data=Auto)
  cv.error[d] = loocv(glm.fit)
}

cv.error

plot(degree, cv.error, type="b")

# 10-fold CV
cv.error10 = rep(0,5)
cv.error10
for(d in degree){
  glm.fit = glm(mpg~poly(horsepower,d), data = Auto)
  cv.error10[d] = cv.glm(Auto, glm.fit, K = 10)$delta[1]
}

lines(degree, cv.error10, col = "red")

# Boostrap
# Minimum risk investment - section 5.2
alpha = function(x,y){
  vx=var(x)
  vy=var(y)
  cxy=cov(x,y)
  (vx-vy)/(vx+vy-2*cxy)
}

alpha(Portfolio$X, Portfolio$Y)

# What is standard error of alpha?

alpha.fn=function(data, index){
  with(data[index,],alpha(X,Y)) #Using the data in the datafram, run the command
}

alpha.fn(Portfolio, 1:100)

set.seed(1)
alpha.fn(Portfolio,sample(1:100, 100, replace=TRUE))

boot.out=boot(Portfolio,alpha.fn,R=1000)
boot.out
plot(boot.out)
