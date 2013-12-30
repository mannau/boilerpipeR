# TODO: Add comment
# 
# Author: mario
###############################################################################

library(RCurl)

url <- "http://quantivity.wordpress.com/2012/11/09/multi-asset-market-regimes/"
content <- getURL(url)
content <- iconv(content, "UTF-8", "ASCII//TRANSLIT")
save(content, file = "/home/mario/Dropbox/Private/workspace/sentiment/pkg/boilerpipeR/data/content.rda")
