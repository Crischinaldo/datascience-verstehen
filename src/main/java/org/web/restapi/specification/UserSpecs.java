package org.web.restapi.specification;

import org.springframework.data.jpa.domain.Specification;
import org.web.restapi.model.User;
import org.web.restapi.model.User_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserSpecs {

    public static Specification<User> getUsersByFirstNameSpec(String firstName) {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                Predicate equalPredicate = criteriaBuilder.equal(root.get(User_.firstName), firstName);
                return equalPredicate;
            }
        };
    }

}
