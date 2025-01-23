package com.example.fieldinjection

import javax.inject.Qualifier

/**
 * https://medium.com/@ramadan123sayed/understanding-kotlin-annotations-a-comprehensive-guide-9a60c329d76b#:~:text=The%20%40Target%20annotation%20specifies%20the,an%20annotation%20can%20be%20applied.
 */
@Qualifier
@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.PROPERTY
)//EmailQualifier - Where applicable
@Retention(AnnotationRetention.RUNTIME)//EmailQualifier - How long applicable
annotation class EmailQualifier

//By applying the target we can stop the misuse of Qualifier
@Qualifier
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER)//Where applicable
@Retention(AnnotationRetention.RUNTIME)
annotation class MessageQualifier


