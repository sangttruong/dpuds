# The stock market data

library(ISLR)
names(Smarket)
dim(Smarket) # Dimention of the dataset (row - column)
summary(Smarket)
pairs(Smarket) # Pairwise graph
cor(Smarket[,-9]) #Covariance matrix, without column 9
attach(Smarket)
plot(Volume)

# Logistic regression

glm.fits = glm(Direction~Lag1+Lag2+Lag3+Lag4+Lag5+Volume, data=Smarket, family=binomial)
summary(glm.fits)
summary(glm.fits)$coef
summary(glm.fits)$coef[,4]
?predict
glm.probs=predict(glm.fits,type="response")
glm.probs[1:10]
