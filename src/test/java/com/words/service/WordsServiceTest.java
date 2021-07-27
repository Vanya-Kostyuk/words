package com.words.service;

import com.words.dto.Words;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class WordsServiceTest {

    private WordsService wordsService = new WordsService();

    @Test
    public void processDataValid() {
        List<String> inputData = new ArrayList<>();
        inputData.add("fish");
        inputData.add("horse");
        inputData.add("egg");
        inputData.add("goose");
        inputData.add("eagle");
        Words requestWords = new Words();
        requestWords.setWords(inputData);

        List<String> expectedList = new ArrayList<>();
        expectedList.add("fish");
        expectedList.add("horse");
        expectedList.add("egg");
        expectedList.add("goose");
        expectedList.add("eagle");
        Words expectedWords = new Words();
        expectedWords.setWords(expectedList);


        Words responseWords = wordsService.processWords(requestWords);
        Assert.assertEquals(expectedWords, responseWords);
    }

    @Test
    public void processValidDataWithTwoValidStrings(){
        List<String> inputData = new ArrayList<>();
        inputData.add("fish");
        inputData.add("horse");
        inputData.add("snake");
        inputData.add("goose");
        inputData.add("eagle");
        Words requestWords = new Words();
        requestWords.setWords(inputData);

        List<String> expectedList = new ArrayList<>();
        expectedList.add("fish");
        expectedList.add("horse");
        Words expectedWords = new Words();
        expectedWords.setWords(expectedList);


        Words responseWords = wordsService.processWords(requestWords);
        Assert.assertEquals(expectedWords, responseWords);
    }

    @Test
    public void processValidDataWithTwo1ValidStrings(){
        List<String> inputData = new ArrayList<>();
        inputData.add("fish");
        inputData.add("horse");
        inputData.add("");
        inputData.add("goose");
        inputData.add("eagle");
        Words requestWords = new Words();
        requestWords.setWords(inputData);

        List<String> expectedList = new ArrayList<>();
        expectedList.add("fish");
        expectedList.add("horse");
        Words expectedWords = new Words();
        expectedWords.setWords(expectedList);


        Words responseWords = wordsService.processWords(requestWords);
        Assert.assertEquals(expectedWords, responseWords);
    }

    @Test
    public void processValidDataWithEmptyValidStrings(){
        List<String> inputData = new ArrayList<>();
        inputData.add("");
        inputData.add("horse");
        inputData.add("");
        inputData.add("goose");
        inputData.add("eagle");
        Words requestWords = new Words();
        requestWords.setWords(inputData);

        List<String> expectedList = new ArrayList<>();
        Words expectedWords = new Words();
        expectedWords.setWords(expectedList);


        Words responseWords = wordsService.processWords(requestWords);
        Assert.assertEquals(expectedWords, responseWords);
    }
}