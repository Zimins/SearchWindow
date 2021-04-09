package com.zplugins.mayihelpu

import com.intellij.ide.BrowserUtil

enum class SearchHost(val prefix: String, val urlTemplate: String) {

    GOOGLE("", "https://www.google.co.kr/search?q=%s"),
    NAVER(":naver", "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%s"),
    ANDROID_DOC(":androiddoc", "https://developer.android.com/s/results/?q=%s"),
    GREPCODE(":grep", "http://grepcode.com/search/?query=%s"),
    STACKOVERFLOW(":stack", "https://stackoverflow.com/search?q=%s"),
    ANDROID_CODE_SEARCH(":androidcode", "https://cs.android.com/search?q=%s");

    fun search(input: String) {
        val searchUrl = String.format(urlTemplate, input)
        print(searchUrl).apply {  }
        BrowserUtil.browse(searchUrl)
    }
}