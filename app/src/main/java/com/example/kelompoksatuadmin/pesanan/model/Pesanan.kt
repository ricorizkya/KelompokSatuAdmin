package com.example.kelompoksatuadmin.pesanan.model

class Pesanan {
    var id: String? = null
    var namaUser: String? = null
    var nomorUser: String? = null
    var emailUser: String? = null
    var alamatUser: String? = null
    var tanggalUser: String? = null
    var ktpUser: String? = null
    var namaPaket: String? = null
    var domisiliPaket: String? = null
    var durasiPaket: String? = null
    var hargaPaket: String? = null
    var guidePaket: String? = null

    constructor() { }

    constructor(id: String?, namaUser: String?, nomorUser: String?, emailUser: String?, alamatUser: String?, tanggalUser: String?, ktpUser: String?, namaPaket: String?, domisiliPaket: String?, durasiPaket: String?, hargaPaket: String?, guidePaket: String?) {
        this.id = id
        this.namaUser = namaUser
        this.nomorUser = nomorUser
        this.emailUser = emailUser
        this.alamatUser = alamatUser
        this.tanggalUser = tanggalUser
        this.ktpUser = ktpUser
        this.namaPaket = namaPaket
        this.domisiliPaket = domisiliPaket
        this.durasiPaket = durasiPaket
        this.hargaPaket = hargaPaket
        this.guidePaket = guidePaket
    }
}