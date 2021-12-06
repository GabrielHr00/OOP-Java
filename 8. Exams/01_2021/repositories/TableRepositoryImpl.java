package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.TableRepository;

import java.util.*;

public class TableRepositoryImpl implements TableRepository<Table> {
    private List<Table> tables;

    public TableRepositoryImpl() {
        this.tables = new LinkedList<>();
    }

    @Override
    public Collection getAllEntities() {
        return tables;
    }

    @Override
    public void add(Table entity) {
        tables.add(entity);
    }

    @Override
    public Table byNumber(int number) {
        return tables.stream().filter(e -> e.getTableNumber() == number)
                .findFirst().orElse(null);
    }
}
