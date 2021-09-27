package com.example.kelompoksatuadmin.paket.model

class Paket {
    var id: String? = null
    var namaPaket: String? = null
    var domisili: String? = null
    var durasi: String? = null
    var harga: String? = null
    var alamatlengkap: String? = null
    var imagePoster: String? = null

    constructor() {}

    constructor(
        id: String?,
        namaPaket: String?,
        domisili: String?,
        durasi: String?,
        harga: String?,
        alamatlengkap: String?,
        imagePoster: String?
    ) {
        this.id = id
        this.namaPaket = namaPaket
        this.domisili = domisili
        this.durasi = durasi
        this.harga = harga
        this.alamatlengkap = alamatlengkap
        this.imagePoster = imagePoster
    }
}