package com.joaohhenriq.kotlin_gridview

class ItemModel {
    var name: String
    var des: String
    var image: Int

    constructor(
        name: String,
        des: String,
        image: Int
    ) {
        this.name = name
        this.des = des
        this.image = image
    }
}