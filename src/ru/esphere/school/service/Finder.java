package ru.esphere.school.service;
import ru.esphere.school.data.Member;
import ru.esphere.school.data.MembersGroup;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Finder {
    /**
     * Поиск групп людей старше определенного возраста.
     *
     * @param groups группы
     * @param targetAge возраст для поиска
     * @return список имен групп из списка групп старше возраста targetAge
     */
    public Set<String> findOldMembers(List<MembersGroup> groups, int targetAge) {
        return groups.stream() // создаем Stream<MembersGroup>
                .flatMap(membersGroup -> membersGroup.getMembers().stream()) // Разворачиваем стрим групп в Stream<Member>
                .filter(member -> member.getAge() > targetAge) // Отбираем людей старше заданного возраста
                .map(Member::getName) // Применяем к отфильтрованному Stream<Member> функцию getName класса Member, превращая его в Stream<String>
                .collect(Collectors.toSet()); // Применяет терминальный метод, возвращающий Set<String>.
    }
}
