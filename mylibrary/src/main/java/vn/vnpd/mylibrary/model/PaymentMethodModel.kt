package vn.vnpd.mylibrary.model

class PaymentMethodModel {
    var name: String
    var id: String
    var isChecked: Boolean

    constructor(name: String, id: String, isChecked: Boolean = false) {
        this.name = name
        this.id = id
        this.isChecked = isChecked
    }
}