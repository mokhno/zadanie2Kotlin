package com.example.kotlinapp3

class Adress {

        private var city: String? = null
        private var country: String? = null

        fun getCity(): String? {
            return city
        }

        fun setCity(city: String) {
            this.city = city
        }

        fun getCountry(): String? {
            return country
        }

        fun setCountry(country: String) {
            this.country = country
        }
}