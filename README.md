1.img-optimizer-gradle-plugin
摘自：https://github.com/chenenyu/img-optimizer-gradle-plugin
作用：压缩项目里面所有的图片，提供有损和无损两种格式
在该module插入apply plugin: 'img-optimizer'
optimizerOptions {
    triggerSize 5
    type "lossy"
    suffix "_opt"
}

2.