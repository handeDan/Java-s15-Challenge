package com.library.repository;

import com.library.models.Reader;

import java.util.ArrayList;
import java.util.List;

public class ReaderRepository {
    //instance variables:
    private List<Reader> readers = new ArrayList<>();

    //methods:
    //adding a new reader:
    public void addReader(Reader reader) {
        readers.add(reader);
        System.out.println("Okuyucu başarıyla eklendi: " + reader.getName());
    }

    //updating the reader:
    public void updateReader(Reader reader) {
        for (int i = 0; i < readers.size(); i++) {
            if (readers.get(i).getId().equals(reader.getId())) {
                readers.set(i, reader);
                System.out.println("Okuyucu başarıyla güncellendi: " + reader.getName());
                return;
            }
        }
        System.out.println("Okuyucu bulunamadı.");
    }

    //removing the reader:
    public void deleteReader(String readerId) {
        readers.removeIf(reader -> reader.getId().equals(readerId));
        System.out.println("Okuyucu başarıyla silindi.");
    }

    //get all readers:
    public List<Reader> getAllReaders() {
        return readers;
    }

    //get a reader by id:
    public Reader getReaderById(String readerId) {
        //System.out.println(readers.size());
        //System.out.println(readerId);
        //System.out.println(readers.get(0).getId());
        for (Reader reader : readers) {
            if (reader.getId().equals(readerId)) {
                return reader;
            }
        }
        return null;
    }


}
