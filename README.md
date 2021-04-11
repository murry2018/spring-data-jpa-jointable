# Spring Data WTF?

This repository demonstrates problem that join table created by spring data jpa named not as JSR 338 specifies.

That is, according to JSR 388 join table should be named `USER_PHONE`, but when we run this application join table has name of `USER_CELLPHONES`.

See [JSR 338 2.1](https://download.oracle.com/otn-pub/jcp/persistence-2_1-fr-spec/JavaPersistence.pdf) Section 2.10.5.2 "Unidirection ManyToMany Relationships", page 53.
