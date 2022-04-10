package com.medium.audhil.springbootrestrepositorydemo.repo;

import com.medium.audhil.springbootrestrepositorydemo.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "animals", path = "animals")
public interface AnimalRepo extends JpaRepository<Animal, Integer> {
}

/*
*
* localhost:8080/animals
* {
    "_embedded": {
        "animals": [
            {
                "legNos": 4,
                "name": "Lion",
                "type": "wild",
                "hornAvailable": false,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/animals/101"
                    },
                    "animal": {
                        "href": "http://localhost:8080/animals/101"
                    }
                }
            },
            {
                "legNos": 4,
                "name": "Tiger",
                "type": "wild",
                "hornAvailable": false,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/animals/102"
                    },
                    "animal": {
                        "href": "http://localhost:8080/animals/102"
                    }
                }
            },
            {
                "legNos": 2,
                "name": "Kangaroo",
                "type": "wild",
                "hornAvailable": false,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/animals/103"
                    },
                    "animal": {
                        "href": "http://localhost:8080/animals/103"
                    }
                }
            },
            {
                "legNos": 4,
                "name": "Rhino",
                "type": "wild",
                "hornAvailable": true,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/animals/104"
                    },
                    "animal": {
                        "href": "http://localhost:8080/animals/104"
                    }
                }
            },
            {
                "legNos": 4,
                "name": "Cow",
                "type": "domestic",
                "hornAvailable": true,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/animals/105"
                    },
                    "animal": {
                        "href": "http://localhost:8080/animals/105"
                    }
                }
            },
            {
                "legNos": 4,
                "name": "Dog",
                "type": "domestic",
                "hornAvailable": false,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/animals/106"
                    },
                    "animal": {
                        "href": "http://localhost:8080/animals/106"
                    }
                }
            },
            {
                "legNos": 4,
                "name": "Deer",
                "type": "wild",
                "hornAvailable": true,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/animals/107"
                    },
                    "animal": {
                        "href": "http://localhost:8080/animals/107"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/animals"
        },
        "profile": {
            "href": "http://localhost:8080/profile/animals"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 7,
        "totalPages": 1,
        "number": 0
    }
}
* */