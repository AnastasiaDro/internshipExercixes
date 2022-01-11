//Created by Anastasia Drogunova
//Date: 10.01.2022 Time 13:05

package stringPackage

fun main() {
    val packManager = ZipManager()
    val tester = ZipUnzipTester(packManager)
    tester.testZip()
    tester.testUnzip()
}