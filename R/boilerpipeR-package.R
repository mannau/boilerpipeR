#' \pkg{boilerpipeR} interfaces the boilerpipe Java library, created by Christian
#' Kohlschutter \url{https://github.com/kohlschutter/boilerpipe}. It implements robust heuristics
#' to extract the main content from HTML files, removing unessecary
#' elements like ads, banners and headers/footers.
#' 
#' @name boilerpipeR-package
#' @aliases boilerpipe
#' @docType package
#' @title Extract the main content from HTML files
#' @author Mario Annau \email{mario.annau@@gmail}
#' @keywords package
#' @seealso \code{\link{Extractor}} \code{\link{DefaultExtractor}} \code{\link{ArticleExtractor}}
#' @examples
#' \dontrun{
#' data(content)
#' extract <- DefaultExtractor(content)
#' cat(extract)
#' }
NULL

#' Wordpress generated Webpage (retrieved from Quantivity Blog \url{https://quantivity.wordpress.com}).
#' Content is saved as character and ready to be extracted.
#' @name content
#' @docType data
#' @author Mario Annau
#' @references \url{https://quantivity.wordpress.com}
#' @keywords data
#' @examples
#' #Data set has been generated as follows:
#' \dontrun{
#' library(RCurl)
#' url <- "https://quantivity.wordpress.com/2012/11/09/multi-asset-market-regimes/"
#' content <- getURL(url)
#' content <- iconv(content, "UTF-8", "ASCII//TRANSLIT")
#' save(content, file = "content.rda")
#' }
NULL

