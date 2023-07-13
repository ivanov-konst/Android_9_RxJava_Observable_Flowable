package com.example.android_9_rxjavaobservable_flowable


import io.reactivex.Observable;
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

    fun main() {

        // Создаем Observable с числами от 1 до 5
        val observable = Observable.range(1, 5)

        // Применяем операторы для Observable
        observable
            .map { it * 2 } // Умножаем каждое число на 2
            .filter { it % 3 == 0 } // Оставляем только числа, которые делятся на 3 без остатка
            .doOnNext { println("Observable - onNext: $it") } // Выводим каждое число в консоль
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .subscribe()

        // Создаем Flowable с числами от 1 до 5
        val flowable = Flowable.range(1, 5)

        // Применяем операторы для Flowable
        flowable
            .map { it * 3 } // Умножаем каждое число на 3
            .skipLast(2) // Пропускаем последние 2 числа
            .doOnNext { println("Flowable - onNext: $it") } // Выводим каждое число в консоль
            .subscribeOn(Schedulers.computation())
            .observeOn(Schedulers.single())
            .subscribe()

        // Ждем некоторое время для завершения всех операций
        Thread.sleep(1000)
    }
