package me.ingannatore.pocs.commons.validation

abstract class ResourceValidator<T> {
    abstract fun validate(it: T)
}
