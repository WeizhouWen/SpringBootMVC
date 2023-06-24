package com.example.mvc;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DocumentService {
    private Map<Integer, Document> documentMap = new HashMap<>();
    private AtomicInteger idGenerator = new AtomicInteger();

    public Document createDocument(Document document) {
        if (document.getContent() == null) {
            throw new IllegalArgumentException("Document content is required.");
        }

        Integer id = idGenerator.incrementAndGet();
        document.setId(id);
        documentMap.put(id, document);
        return document;
    }

    public Document getDocument(Integer id) throws Exception {
        Document document = documentMap.get(id);
        if (document == null) {
            throw new Exception("Document not found with ID: " + id);
        }
        return document;
    }

    public Document updateDocument(Integer id, Document updatedDocument) throws Exception {
        Document document = documentMap.get(id);
        if (document == null) {
            throw new Exception("Document not found with ID: " + id);
        }
        if (updatedDocument.getContent() != null) {
            document.setContent(updatedDocument.getContent());
        }
        return document;
    }

    public void deleteDocument(Integer id) throws Exception {
        Document document = documentMap.remove(id);
        if (document == null) {
            throw new Exception("Document not found with ID: " + id);
        }
    }
}
