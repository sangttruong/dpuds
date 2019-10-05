# The stock market data

library(ISLR)
names(Smarket)
dim(Smarket) # Dimention of the dataset (row - column)
summary(Smarket)
pairs(Smarket,col=Smarket$Direction) # Pairwise graph
cor(Smarket[,-9]) #Covariance matrix, without column 9
attach(Smarket)
plot(Volume)

# Logistic regression

glm.fits = glm(Direction~Lag1+Lag2+Lag3+Lag4+Lag5+Volume, data=Smarket, family=binomial)
summary(glm.fits)
summary(glm.fits)$coef
summary(glm.fits)$coef[,4]

glm.probs=predict(glm.fits,type="response")
glm.probs[1:5]
glm.pred = ifelse(glm.probs >0.5,"Up","Down")
attach(Smarket)
table(glm.pred,Direction)
mean(glm.pred == Direction) # Performance: 0.5216

# Making training and test set
train = Year<2005
glm.fit=glm(Direction~Lag1+Lag2+Lag3+Lag4+Lag5+Volume, data=Smarket, family=binomial,subset=train)
glm.probs = predict(glm.fit,newdata=Smarket[!train,],type="response")
glm.pred=ifelse(glm.probs >0.5, "Up","Down")
Direction.2005=Smarket$Direction[!train]
table(glm.pred,Direction.2005)
mean(glm.pred==Direction.2005) # Performance: 0.4801587

# Fit smaller model
glm.fit=glm(Direction~Lag1+Lag2,
            data=Smarket, family=binomial,subset=train)
glm.probs = predict(glm.fit,newdata=Smarket[!train,],type="response")
glm.pred=ifelse(glm.probs >0.5, "Up","Down")
Direction.2005=Smarket$Direction[!train]
table(glm.pred,Direction.2005)
mean(glm.pred==Direction.2005) # Performance: 0.5595238
summary(glm.fit)