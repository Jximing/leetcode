/**
 *
 * @author mingjiexian
 * @date 2020-11-24 16:57
 *
 */

fun main(args: Array<String>) {

    print(arrayListOf("1","2","3","4").reduceRight { z, c -> c + z })
}