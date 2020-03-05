package com.github.seratch.jslack.api.methods.response.chat.scheduled_messages;

import com.github.seratch.jslack.api.methods.SlackApiResponse;
import com.github.seratch.jslack.api.model.Attachment;
import com.github.seratch.jslack.api.model.ResponseMetadata;
import com.github.seratch.jslack.api.model.block.LayoutBlock;
import lombok.Data;

import java.util.List;

@Data
public class ChatScheduledMessagesListResponse implements SlackApiResponse {

    private boolean ok;
    private String warning;
    private String error;
    private String needed;
    private String provided;

    private List<ScheduledMessage> scheduledMessages;
    private ResponseMetadata responseMetadata;

    @Data
    public static class ScheduledMessage {
        private String id;
        private String channelId;
        private String text;
        private List<Attachment> attachments;
        private List<LayoutBlock> blocks;
        private Integer postAt;
        private Integer dateCreated;
    }

}