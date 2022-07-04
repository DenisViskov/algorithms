package com.company.widthSearch;

import java.util.*;

public class WidthSearcher {

    private static final Set<Person> CHECKED_FRIENDS = new HashSet<>();

    public static Person widthSearch(final Person person, final String friendName) {
        final Queue<Person> queue = new LinkedList<>();
        queue.add(person);

        while (!queue.isEmpty()) {
            final var friend = queue.poll();

            if (CHECKED_FRIENDS.contains(friend)) {
                continue;
            }
            if (friend.getName().equals(friendName)) {
                return friend;
            }
            if (!friend.getFriends().isEmpty()) {
                queue.addAll(friend.getFriends());
            }
            CHECKED_FRIENDS.add(friend);
        }
        return null;
    }
}
