# Ridge Regression and the Lasso

library(glmnet)
x=model.matrix(Salary~.-1,data=Hitters)
y=model.matrix(Hitters[,19])

Hitters

dim(y)
dim(x)

Hitters
y
Hitters
?model.matrix

#Ridge-regression: alpha = 0
fit.ridge = glmnet(x,y,alpha = 0)
plot(fit.ridge,xvar = "lambda", label=TRUE)