package example;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class CommentaryController {

	@MessageMapping("/live-comment")
    @SendTo("/topic/commentary")
    public Comment liveComment(Commentary message) throws Exception {
        return new Comment(HtmlUtils.htmlEscape(message.getCommentary()));
    }
}
