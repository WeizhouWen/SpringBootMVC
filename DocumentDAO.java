package com.example.mvc;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DocumentDAO {
    private Map<Integer, Document> documentMap = new HashMap<>();
    private int idCounter = 1;

    public Integer createDocument(Document document) {
        Integer id = idCounter++;
        document.setId(id);
        documentMap.put(id, document);
        return id;
    }

    public Document getDocument(Integer id) {
        return documentMap.get(id);
    }

    public List<Document> getAllDocuments() {
        return new ArrayList<>(documentMap.values());
    }

    public boolean updateDocument(Integer id, Document updatedDocument) {
        Document document = documentMap.get(id);
        if (document != null) {
            document.setContent(updatedDocument.getContent());
            return true;
        }
        return false;
    }

    public boolean deleteDocument(Integer id) {
        return documentMap.remove(id) != null;
    }
}
