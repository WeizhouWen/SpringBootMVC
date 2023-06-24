package com.example.mvc;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class DocumentDAO {
    private Map<Integer, Document> documentMap = new HashMap<>();
    private AtomicInteger idGenerator = new AtomicInteger();

    public Document create(Document document) {
        Integer id = idGenerator.incrementAndGet();
        document.setId(id);
        documentMap.put(id, document);
        return document;
    }

    public Document getById(Integer id) {
        return documentMap.get(id);
    }

    public Document update(Document document) {
        documentMap.put(document.getId(), document);
        return document;
    }

    public void delete(Integer id) {
        documentMap.remove(id);
    }
}

