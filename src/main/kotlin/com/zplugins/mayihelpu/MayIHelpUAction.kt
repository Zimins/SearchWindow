package com.zplugins.mayihelpu

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.InputValidator
import com.intellij.openapi.ui.Messages
import com.intellij.ui.layout.panel

class MayIHelpUAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        val project = event.project
        if (project != null) {

            var input = Messages.showInputDialog(null, "Search it!", null, "", QueryValidator()) ?: return

            val searchHost = getSearchHost(input)
            if (hasCommand(input)) {
                input = getRawInput(input)
            }

            searchHost.search(input)
        }
    }

    private fun getRawInput(input: String): String {
        val borderPos = input.indexOf(' ')
        return input.substring(borderPos + 1)
    }

    private fun hasCommand(input: String): Boolean{
        return input[0] == ':'
    }

    private fun getCommand(input: String): String {
        return input.split(" ")[0]
    }

    private fun getSearchHost(input: String): SearchHost {
        val args = input.split(" ")

        return when(args[0]) {
            ":naver" -> SearchHost.NAVER
            ":android" -> SearchHost.ANDROID
            ":grep" -> SearchHost.GREPCODE
            else -> SearchHost.GOOGLE
        }
    }

    class QueryValidator : InputValidator {
        override fun checkInput(input: String?): Boolean {
            return true
        }

        override fun canClose(p0: String?): Boolean {
            return true
        }

    }
}