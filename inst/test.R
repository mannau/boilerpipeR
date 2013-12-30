# TODO: Add comment
# 
# Author: mario
###############################################################################

library(boilerpipeR)
library(RCurl)

testurl <- "http://www.handelsblatt.com/finanzen/boerse-maerkte/marktberichte/investoren-treten-die-flucht-an-/4650432.html"

e1 <- ArticleExtractor(testurl, asText = FALSE)
cat(e1)

uget <- getURL(testurl)
e2 <- ArticleExtractor(uget)
cat(e2)