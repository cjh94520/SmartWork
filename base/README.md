//加入一些常用的依赖库，基于稳定的原则，短期仍在频繁更新的(2个月内有commit)，或者不需要进行二次开发适配的，
//直接在gradle配置，其余的以document的形式加入到module,保持项目的一致性和适配性。

1.LogUtils(2016.8.12加入)
地址：https://github.com/pengwei1024/LogUtils/commits/master
加入原因：支持直接打印数据集合,如List、Set、Map、数组等
         准确显示调用方法、行，快速定位所在文件位置
         提供debug和release两个不同的依赖库
配置：gradle

2.leakcanary
地址：https://github.com/square/leakcanary
加入原因：内存泄漏分析
配置：gradle
