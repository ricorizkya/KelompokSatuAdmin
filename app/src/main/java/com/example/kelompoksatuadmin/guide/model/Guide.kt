package com.example.kelompoksatuadmin.guide.model

class Guide {
    var id: String? = null
    var namaGuide: String? = null
    var nomorGuide: String? = null
    var emailGuide: String? = null
    var alamatGuide: String? = null
//    var ktpGuide: String? = null
    var fotoGuide: String? = null

    constructor() { }

    constructor(id: String?, namaGuide: String?, nomorGuide: String?, emailGuide: String?, alamatGuide: String?, fotoGuide: String?) {
        this.id = id
        this.namaGuide = namaGuide
        this.nomorGuide = nomorGuide
        this.emailGuide = emailGuide
        this.alamatGuide = alamatGuide
//        this.ktpGuide = ktpGuide
        this.fotoGuide = fotoGuide
    }

}